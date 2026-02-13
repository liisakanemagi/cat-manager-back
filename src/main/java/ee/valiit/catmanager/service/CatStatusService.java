package ee.valiit.catmanager.service;

import ee.valiit.catmanager.controller.catstatus.CatStatusInfo;
import ee.valiit.catmanager.infrastructure.exception.PrimaryKeyNotFoundException;
import ee.valiit.catmanager.persistence.catstatus.CatStatus;
import ee.valiit.catmanager.persistence.catstatus.CatStatusMapper;
import ee.valiit.catmanager.persistence.catstatus.CatStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatStatusService {

    private final CatStatusRepository catStatusRepository;
    private final CatStatusMapper catStatusMapper;

    public List<CatStatusInfo> getCatStatuses(){
        List<CatStatus> catStatuses = catStatusRepository.findAll();
        return catStatusMapper.toCatStatusInfos(catStatuses);
    }

    public CatStatus getValidCatStatus(Integer statusId){
       CatStatus catStatus = catStatusRepository.findById(statusId)
               .orElseThrow(() -> new PrimaryKeyNotFoundException("statusId", statusId));
       return catStatus;
    }
}


