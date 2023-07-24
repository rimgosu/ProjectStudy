from flask import Flask, request
from PIL import Image
import pytesseract
import io

app = Flask(__name__)

@app.route('/ocr', methods=['POST'])
def ocr():
    if 'image' not in request.files:
        return 'No image file'

    file = request.files['image']
    image = Image.open(io.BytesIO(file.read()))
    text = pytesseract.image_to_string(image)

    return text

if __name__ == '__main__':
    app.run(port=5001)