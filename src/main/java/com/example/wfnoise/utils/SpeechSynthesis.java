package com.example.wfnoise.utils;

import com.microsoft.cognitiveservices.speech.*;
import java.util.concurrent.ExecutionException;

public class SpeechSynthesis {
    private static String YourSubscriptionKey = "605ff11fcd0f46e8a08c8379c1e00bfb";
    private static String YourServiceRegion = "eastus";

    public static byte[] getAudioData(String text) throws InterruptedException, ExecutionException {
        SpeechConfig speechConfig = SpeechConfig.fromSubscription(YourSubscriptionKey, YourServiceRegion);

        speechConfig.setSpeechSynthesisVoiceName("en-US-JennyNeural"); 
        try (SpeechSynthesizer speechSynthesizer = new SpeechSynthesizer(speechConfig)) {
			// Get text from the console and synthesize to the default speaker.
			if (text==null || text.isEmpty())
			{
			    return null;
			}

			SpeechSynthesisResult speechRecognitionResult = speechSynthesizer.SpeakTextAsync(text).get();
			if (speechRecognitionResult.getReason() == ResultReason.SynthesizingAudioCompleted) {
			    System.out.println("Speech synthesized to speaker for text [" + text + "]");
			}
			else if (speechRecognitionResult.getReason() == ResultReason.Canceled) {
			    SpeechSynthesisCancellationDetails cancellation = SpeechSynthesisCancellationDetails.fromResult(speechRecognitionResult);
			    System.out.println("CANCELED: Reason=" + cancellation.getReason());

			    if (cancellation.getReason() == CancellationReason.Error) {
			        System.out.println("CANCELED: ErrorCode=" + cancellation.getErrorCode());
			        System.out.println("CANCELED: ErrorDetails=" + cancellation.getErrorDetails());
			        System.out.println("CANCELED: Did you set the speech resource key and region values?");
			    }
			}
			return SpeechSynthesis.getAudioData(text);
		}    
    }
}
