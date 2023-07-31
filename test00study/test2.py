from flask import Flask, request, send_file
from PIL import Image
import io

app = Flask(__name__)

@app.route('/upload', methods=['POST'])
def upload_file():
    file = request.files['file']
    img = Image.open(file.stream)
    img.show()

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5001)