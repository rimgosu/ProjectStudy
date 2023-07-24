from flask import Flask, request, jsonify
import torch
import torchvision.transforms as transforms
from PIL import Image

app = Flask(__name__)

# Load the model (Make sure the model is in the same directory)
model = torch.hub.load('ultralytics/yolov5', 'yolov5s')

@app.route('/predict', methods=['POST'])
def predict():
    if 'file' not in request.files:
        return 'No file part'
    file = request.files['file']
    image = Image.open(file.stream)  # Convert the passed file into a PIL Image object

    transform = transforms.Compose([
        transforms.Resize((640, 640)),
        transforms.ToTensor(),
    ])
    image = transform(image).unsqueeze(0)
    preds = model(image)

    # Here you can format the predictions as you likepip install flask torch torchvision pillow

    return jsonify(preds.tolist())

if __name__ == '__main__':
    app.run(debug=True)
