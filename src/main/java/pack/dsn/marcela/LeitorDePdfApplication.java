package pack.dsn.marcela;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeitorDePdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeitorDePdfApplication.class, args);
	}

//	@RequestMapping(value="/lerPDF", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public ResponseEntity<?> lerPdfUploadado(@RequestParam("arquivo") MultipartFile arquivo) throws IOException {		
////		File arquivo = new File("Teste.pdf");
////		InputStream inputStream = new FileInputStream(arquivo);
////		File novoArquivo = new File("src/main/java/PDFs/" + arquivo.getOriginalFilename());
////		novoArquivo.createNewFile();
////		FileOutputStream arquivoOutput = new FileOutputStream(novoArquivo);
////		arquivoOutput.write(arquivo.getBytes());
////		arquivoOutput.close();
//		
//		String extension = FilenameUtils.getExtension(arquivo.getOriginalFilename());
//		if (extension.equals("pdf")) {
//			BufferedInputStream bufferedInput = new BufferedInputStream(arquivo.getInputStream());
//			PDDocument documento = PDDocument.load(bufferedInput);
//			String textoPDF = new PDFTextStripper().getText(documento);
//			
//			return ResponseEntity.ok(textoPDF);			
//		}
//		
//		return ResponseEntity.unprocessableEntity().body("Não pode, não!");		
//	}
}
