package com._42ence.backend.service;

import com._42ence.backend.dto.Response.WikiResponseDTO;
import com._42ence.backend.entity.Subject;
import com._42ence.backend.entity.Wiki;
import com._42ence.backend.repository.SubjectRepository;
import com._42ence.backend.repository.WikiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WikiService {

    @Autowired
    private WikiRepository wikiRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public WikiResponseDTO getSubjectWiki(String subjectName) {
        Subject subject = subjectRepository.findByName(subjectName);

        return convertEntityToWikiResponseDTO(subject);
    }

    private WikiResponseDTO convertEntityToWikiResponseDTO(Subject subject) {
        Long id = wikiRepository.findSubjectWikiId(subject.getId(), wikiRepository.findLastVersionOfSubject(subject.getId()));
        Wiki wiki = wikiRepository.findById(id).get();

        WikiResponseDTO wikiResponseDTO = new WikiResponseDTO();
        wikiResponseDTO.setBody(wiki.getBody());
        wikiResponseDTO.setVersion(wiki.getVersion());
        wikiResponseDTO.setEditor(wiki.getEditor());

        return wikiResponseDTO;
    }
}
