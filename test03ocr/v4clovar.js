import axios from 'axios';

let ocrInvokeUrl = "키입력"; // 여기에 OCR Invoke URL을 입력하세요.
let ocrSecretKey = "키입력="; // 여기에 X-OCR-SECRET을 입력하세요.
let imageUrl = "https://blog.kakaocdn.net/dn/by79KZ/btqFHbaHAWd/ymCPJQOETF4WyFEocKpIfK/img.jpg"; // 여기에 이미지 URL을 입력하세요.

let headers = {
    "Content-Type": "application/json",
    "X-OCR-SECRET": ocrSecretKey
};

let body = {
    "images": [
        {
            "format": "jpg",
            "name": "medium",
            "data": null,
            "url": imageUrl
        }
    ],
    "lang": "ko",
    "requestId": "string",
    "resultType": "string",
    "timestamp": Date.now(),
    "version": "V1"
};

axios.post(ocrInvokeUrl, body, {headers: headers})
    .then(response => {
        console.log(response.data.images[0].fields);
    })
    .catch(error => {
        console.log("error", error);
    });


