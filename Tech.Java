class Tech{
public static void main(String[] args){

List<FrameFeatures> featuresList = extractFeaturesFromVideos(videoFolderPath);

// Step 3: Model Training
// Split data into training and testing sets
Dataset trainSet = splitDataset(featuresList, 0.8);
Dataset testSet = splitDataset(featuresList, 0.2);

// Train a classification model (e.g., SVM, CNN)
Model model = trainModel(trainSet);

// Step 4: Evaluation
// Evaluate the model on the test set
EvaluationResults results = evaluateModel(model, testSet);
System.out.println("Accuracy: " + results.getAccuracy());
System.out.println("Precision: " + results.getPrecision());
System.out.println("Recall: " + results.getRecall());
System.out.println("F1-score: " + results.getF1Score());

// Step 5: Deployment
// Use the trained model for inference on new video samples
Video newVideo = loadNewVideo(videoFilePath);
boolean isViolent = model.predict(newVideo);
System.out.println("Predicted class: " + (isViolent ? "Violence" : "Non-violence"));
}
}