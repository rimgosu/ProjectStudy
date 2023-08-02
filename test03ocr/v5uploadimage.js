// app.js
const express = require('express');
const multer = require('multer');
const path = require('path');

const app = express();
const upload = multer({ dest: path.join(__dirname, 'uploads/') });

app.use(express.static(path.join(__dirname, 'public')));

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

app.post('/upload', upload.single('image'), (req, res) => {
  if (!req.file) {
    return res.status(400).send('No image uploaded');
  }

  // 이미지를 업로드하고 생성된 이미지 파일 경로를 얻습니다.
  const imageUrl = req.file.path;
  // 이미지 URL을 클라이언트로 응답합니다.
  res.send(imageUrl);
});

app.listen(5500, () => {
  console.log('Server is running on port 5500');
});