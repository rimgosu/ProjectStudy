// // // We declared all our imports
// // const express = require("express");
// // const app = express();
// // const fs = require("fs");
// // const multer = require('multer');
// // const {TesseractWorker } = require('tesseract.js');
// // const worker = new TesseractWorker();

// // // Storage
// // const storage = multer.diskStorage({
// //     destination: (req,file,cb) => {
// //         cb(null, "./uploads");
// //     },
// //     filename: (req,file,cb) => {
// //         cb(null, file.originalname);
// //     }
// // });
// // const upload = multer({storage: storage}).single("avatar");

// // app.set("view engine", "ejs"); 

// // // ROUTES
// // app.get('/', (req,res) => {
// //     res.render("index");
// // });

// // // ver1
// // app.post('/upload', (req,res) => {
// //     upload(req,res, err => {
// //         fs.readFile(`./uploads/${req.file.originalname}`, (err, data) => {
// //             if(err) return console.log("this is your error", err);

// //             worker
// //             .recognize(data, "eng", {tessjs_create_pdf: "1"})
// //             .progress(progress => {
// //                 console.log(progress);
// //             })
// //             .then(result => {
// //                 res.send(result.text);
// //             })
// //             .finally(() => worker.terminate());
// //         });
// //     });
// // });


// // // Start up our server
// // const PORT = 5000 || process.env.PORT;
// // app.listen(PORT, () => console.log(`hey i'm running on port ${PORT}`));



// const express = require("express");
// const app = express();
// const { createWorker } = require('tesseract.js');

// app.set("view engine", "ejs"); 

// app.get('/', (req,res) => {
//     res.render("index");
// });

// app.post('/upload', async (req,res) => {
//     const imageUrl = req.body.imageUrl; // get image URL from request body

//     const worker = createWorker({
//       logger: m => console.log(m)
//     });

//     await worker.loadLanguage('eng');
//     await worker.initialize('eng');
//     const { data: { text } } = await worker.recognize(imageUrl);
//     console.log(text);

//     res.send(text);
//     await worker.terminate();
// });

// const PORT = 5000 || process.env.PORT;
// app.listen(PORT, () => console.log(`hey i'm running on port ${PORT}`));

// app.js
const express = require('express');
const multer = require('multer');
const path = require('path');

const app = express();
const upload = multer({ dest: 'uploads/' });

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

app.listen(3000, () => {
  console.log('Server is running on port 3000');
});