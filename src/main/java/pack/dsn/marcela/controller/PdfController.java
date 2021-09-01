package pack.dsn.marcela.controller;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("lerPDF")
public class PdfController {

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> lerPdfUploadado(@RequestParam("arquivo") MultipartFile arquivo) throws IOException {		
//		File arquivo = new File("Teste.pdf");
//		InputStream inputStream = new FileInputStream(arquivo);
//		File novoArquivo = new File("src/main/java/PDFs/" + arquivo.getOriginalFilename());
//		novoArquivo.createNewFile();
//		FileOutputStream arquivoOutput = new FileOutputStream(novoArquivo);
//		arquivoOutput.write(arquivo.getBytes());
//		arquivoOutput.close();
		
		String extension = FilenameUtils.getExtension(arquivo.getOriginalFilename());
		if (extension.equals("pdf")) {
			BufferedInputStream bufferedInput = new BufferedInputStream(arquivo.getInputStream());
			PDDocument documento = PDDocument.load(bufferedInput);
			String textoPDF = new PDFTextStripper().getText(documento);	        
		    if(documento != null){
		    	documento.close();
		    }
		    
			return ResponseEntity.ok(textoPDF);			
		}
		
		return ResponseEntity.unprocessableEntity().body("Não pode, não!");		
	}
	
}
