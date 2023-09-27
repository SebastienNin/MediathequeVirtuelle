package mediatheque.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/upload")
public class UploadFileController {

	private final String uploadDirectory = "./uploads/";

	@GetMapping(value = "/{fileName:.+}")
	public ResponseEntity<Resource> getFile(@PathVariable String fileName) {
		MediaType contentType = null;
		// Trouver l'index du dernier point dans le nom de fichier
		int dernierPointIndex = fileName.lastIndexOf(".");

		if (dernierPointIndex > 0) {
			// Extraire l'extension en utilisant substring
			String extension = fileName.substring(dernierPointIndex + 1);
			if (extension.equals("jpg")) {
				contentType = MediaType.IMAGE_JPEG;
			} else if (extension.equals("png")) {
				contentType = MediaType.IMAGE_PNG;
			} else {
				return ResponseEntity.status(500).build();
			}
		} else {
			System.out.println("Le fichier n'a pas d'extension.");
		}

		try {
			// Créez un chemin complet vers le fichier demandé
			Path filePath = Paths.get(uploadDirectory).resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());

			if (resource.exists()) {
				return ResponseEntity.ok().contentType(contentType).header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (IOException e) {
			// Gérez l'exception appropriée, par exemple, si le fichier n'existe pas ou s'il
			// y a une autre erreur d'E/S.
			return ResponseEntity.status(500).build();
		}
	}

	@PostMapping("")
	public ResponseEntity<String> handleFileUpload(MultipartFile file) throws IOException {
		String originalFileName = file.getOriginalFilename();
		String extension = "";
		MediaType contentType = null;
		int dernierPointIndex = originalFileName.lastIndexOf(".");

		if (dernierPointIndex > 0) {
			extension = originalFileName.substring(dernierPointIndex + 1);
			if (extension.equals("jpg")) {
				contentType = MediaType.IMAGE_JPEG;
			} else if (extension.equals("png")) {
				contentType = MediaType.IMAGE_PNG;
			} else {
				return ResponseEntity.status(500).build();
			}
		} else {
			System.out.println("Le fichier n'a pas d'extension.");
		}
		// Générez un nom de fichier unique, par exemple en utilisant UUID
		String fileName = UUID.randomUUID().toString() + "." + extension;

		// Assurez-vous que le répertoire d'upload existe ou créez-le s'il n'existe pas
		File directory = new File(uploadDirectory);
		if (!directory.exists()) {
			directory.mkdirs(); // Créez le répertoire et ses parents s'ils n'existent pas
		}

		// Créez le chemin complet du fichier et écrivez les données binaires dedans
		Path filePath = Paths.get(uploadDirectory, fileName);
		Files.write(filePath, file.getBytes());

		// Vous pouvez également effectuer d'autres opérations ici, comme mettre à jour
		// la base de données

		// Créez un objet JSON manuellement
		String jsonResponse = "{\"fileName\": \"" + fileName + "\"}";

		// Renvoyez la réponse JSON
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(jsonResponse);
	}
}
