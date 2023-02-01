package com._42ence.backend.service;

import com._42ence.backend.dto.Response.*;
import com._42ence.backend.entity.Subject;
import com._42ence.backend.entity.Wiki;
import com._42ence.backend.repository.RatingRepository;
import com._42ence.backend.repository.SubjectRepository;
import com._42ence.backend.repository.WikiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final RatingRepository ratingRepository;
    private final WikiRepository wikiRepository;


    public List<SubjectListResponseDTO> getSubjectList(){
        return subjectRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private SubjectListResponseDTO convertEntityToDto(Subject subject) {

        SubjectListResponseDTO subjectListResponseDTO =  new SubjectListResponseDTO();
        subjectListResponseDTO.setSubjectName(subject.getName());
        subjectListResponseDTO.setCircle(subject.getCircle());

        subjectListResponseDTO.setAvgStarRating(ratingRepository.starRatingAvg(subject.getId()));
        subjectListResponseDTO.setTotalRatingNum(ratingRepository.countRating(subject.getId()));
        if (subjectListResponseDTO.getAvgStarRating() == null ){
            subjectListResponseDTO.setAvgStarRating(0.0);
        }
        if (subjectListResponseDTO.getTotalRatingNum() == null){
            subjectListResponseDTO.setTotalRatingNum(0);
        }
        return subjectListResponseDTO;
    }


    public SubjectResponseDTO getSubjectDetail(String subjectName){

        Subject subject = subjectRepository.findByName(subjectName);

        return convertEntityToSubjectResponseDTO(subject);
    }

    private SubjectResponseDTO convertEntityToSubjectResponseDTO(Subject subject){

        TotalTimeTakenResponseDTO totalTimeTakenResponseDTO = getTimeTaken(subject);
        TotalAmountStudyResponseDTO totalAmountStudyResponseDTO = getAmountStudy(subject);
        TotalBonusResponseDTO totalBonusResponseDTO = getBonus(subject);
        TotalDifficultyResponseDTO totalDifficultyResponseDTO = getDifficulty(subject);

        Long id = wikiRepository.findSubjectWikiId(subject.getId(), subject.getWikiVersion());
        Wiki wiki = wikiRepository.findById(id).get();

        SubjectResponseDTO subjectResponseDTO = new SubjectResponseDTO();
        subjectResponseDTO.setSubjectName(subject.getName());
        subjectResponseDTO.setCircle(subject.getCircle());
        subjectResponseDTO.setSubjectDescription(subject.getDescription());
        subjectResponseDTO.setSubjectWiki(wiki);
        subjectResponseDTO.setAvgStarRating(ratingRepository.starRatingAvg(subject.getId()));
        subjectResponseDTO.setTotalRatingNum(ratingRepository.countRating(subject.getId()));
        subjectResponseDTO.setTotalTimeTaken(totalTimeTakenResponseDTO);
        subjectResponseDTO.setTotalAmountStudy(totalAmountStudyResponseDTO);
        subjectResponseDTO.setTotalBonus(totalBonusResponseDTO);
        subjectResponseDTO.setTotalDifficulty(totalDifficultyResponseDTO);

        return subjectResponseDTO;
    }

    private TotalTimeTakenResponseDTO getTimeTaken(Subject subject){

        TotalTimeTakenResponseDTO totalTimeTakenResponseDTO = new TotalTimeTakenResponseDTO();
        totalTimeTakenResponseDTO.setAWeek(ratingRepository.timeTakenAWeekCount(subject.getId()));
        totalTimeTakenResponseDTO.setTwoWeek(ratingRepository.timeTakenTwoWeekCount(subject.getId()));
        totalTimeTakenResponseDTO.setThreeWeek(ratingRepository.timeTakenThreeWeekCount(subject.getId()));
        totalTimeTakenResponseDTO.setAMonth(ratingRepository.timeTakenAMonthCount(subject.getId()));
        totalTimeTakenResponseDTO.setThreeMonth(ratingRepository.timeTakenThreeMonthCount(subject.getId()));

        return totalTimeTakenResponseDTO;
    }

    private TotalAmountStudyResponseDTO getAmountStudy(Subject subject) {

        TotalAmountStudyResponseDTO totalAmountStudyResponseDTO = new TotalAmountStudyResponseDTO();

        totalAmountStudyResponseDTO.setLow(ratingRepository.amountStudyLowCount(subject.getId()));
        totalAmountStudyResponseDTO.setMiddle(ratingRepository.amountStudyMiddleCount(subject.getId()));
        totalAmountStudyResponseDTO.setHigh(ratingRepository.amountStudyHighCount(subject.getId()));

        return totalAmountStudyResponseDTO;
    }

    private TotalBonusResponseDTO getBonus(Subject subject) {

        TotalBonusResponseDTO totalBonusResponseDTO = new TotalBonusResponseDTO();

        totalBonusResponseDTO.setNo(ratingRepository.bonusNoCount(subject.getId()));
        totalBonusResponseDTO.setLittle(ratingRepository.bonusLittleCount(subject.getId()));
        totalBonusResponseDTO.setComplete(ratingRepository.bonusCompleteCount(subject.getId()));

        return totalBonusResponseDTO;
    }
    private TotalDifficultyResponseDTO getDifficulty(Subject subject) {

        TotalDifficultyResponseDTO totalDifficultyResponseDTO = new TotalDifficultyResponseDTO();

        totalDifficultyResponseDTO.setEasy(ratingRepository.difficultyEasyCount(subject.getId()));
        totalDifficultyResponseDTO.setNormal(ratingRepository.difficultyNormalCount(subject.getId()));
        totalDifficultyResponseDTO.setHard(ratingRepository.difficultyHardCount(subject.getId()));

        return totalDifficultyResponseDTO;
    }
}
