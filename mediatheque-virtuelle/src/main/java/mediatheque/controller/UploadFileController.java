package mediatheque.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/upload")
public class UploadFileController {

	@PostMapping("")
	public ResponseEntity<String> handleFileUpload(@RequestBody byte[] fileData) throws IOException {
	    // Générez un nom de fichier unique, par exemple en utilisant UUID
	    String fileName = UUID.randomUUID().toString() + ".jpg";
	    
	    // Spécifiez le chemin du répertoire où vous souhaitez enregistrer le fichier
	    String uploadDirectory = "./uploads/";

	    // Assurez-vous que le répertoire d'upload existe ou créez-le s'il n'existe pas
	    File directory = new File(uploadDirectory);
	    if (!directory.exists()) {
	        directory.mkdirs(); // Créez le répertoire et ses parents s'ils n'existent pas
	    }

	    // Créez le chemin complet du fichier et écrivez les données binaires dedans
	    Path filePath = Paths.get(uploadDirectory, fileName);
	    Files.write(filePath, fileData);

	    // Vous pouvez également effectuer d'autres opérations ici, comme mettre à jour la base de données

	    return ResponseEntity.ok("File uploaded successfully");
	}


}
