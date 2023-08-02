document.getElementById('convertButton').addEventListener('click', async function() {
    const imageUpload = document.getElementById('imageUpload');
    const file = imageUpload.files[0];
    console.log(file)
    if (file) {
      try {
        const { createWorker } = Tesseract;
        const worker = createWorker({
          logger: m => console.log(m)
        });
        
        await worker.load();
        await worker.loadLanguage('eng');
        await worker.initialize('eng');
        const { data: { text } } = await worker.recognize(file);
        await worker.terminate();
  
        document.getElementById('output').textContent = text;
      } catch (e) {
        console.error(e);
      }
    } else {
      alert('Please upload an image first.');
    }
  });