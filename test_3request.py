import requests

# The URL of your API
url = "http://127.0.0.1:5000/predict"

# The path to the image file
file_path = r"C:\Users\aischool\Desktop\project1\imgs\testimg.jpg"

# Open the file in binary mode
with open(file_path, "rb") as file:
    # Define the multipart form data dictionary
    image_data = {"image": file}

    # Send the POST request
    response = requests.post(url, files=image_data)

# Print the response
print(response.json())
