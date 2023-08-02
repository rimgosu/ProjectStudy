import { createWorker } from 'tesseract.js';
import fs from 'fs';

function removeSpacesAndCommasPreserveNewlines(text) {
    return text.split('\n').map(line => line.replace(/[\s,.]/g, '')).join('\n');
}


async function recognizeTextFromImageUrl(url) {
    const worker = await createWorker({});
    await worker.loadLanguage('eng');
    await worker.initialize('eng');
    const { data: { text } } = await worker.recognize(url);
    await worker.terminate();
    return text;
}

async function recognizeTextFromLocalImage(filePath) {
    const worker = await createWorker({});
    await worker.loadLanguage('kor');
    await worker.initialize('kor');
    const { data: { text } } = await worker.recognize(fs.readFileSync(filePath));
    await worker.terminate();
    return removeSpacesAndCommasPreserveNewlines(text);
}

// let url = "https://tesseract.projectnaptha.com/img/eng_bw.png";
// let text = await recognizeTextFromImageUrl(url);
// console.log(text);
let filePath = "testimg.jpg";
let text2 = await recognizeTextFromLocalImage(filePath);
console.log(text2);