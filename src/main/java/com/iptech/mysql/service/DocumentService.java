package com.iptech.mysql.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iptech.mysql.domain.Document;
import com.iptech.mysql.repository.DocumentRepository;

@Service
public class DocumentService {
	@Autowired
	private DocumentRepository documentRepo;
	
	public Document save (Document document) {
		return documentRepo.save(document);
	}

	public Document findById(Long documentId) {
		Optional<Document> documentOpt = documentRepo.findById(documentId);
		return documentOpt.orElse(new Document());
	}
	public void delete(Long documentId) {
		documentRepo.deleteById(documentId);
	}
}
