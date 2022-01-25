package projecthrissinauKodingBE18.projecthrisbe18.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projecthrissinauKodingBE18.projecthrisbe18.common.RestResult;
import projecthrissinauKodingBE18.projecthrisbe18.common.StatusCode;
import projecthrissinauKodingBE18.projecthrisbe18.entity.Division;
import projecthrissinauKodingBE18.projecthrisbe18.service.DivisionService;

import java.util.ArrayList;

@RestController
@RequestMapping("divisions")
public class DivisionController extends BaseController {

    @Autowired
    private DivisionService service;

    @GetMapping
    public RestResult get(@RequestParam(value = "param", required = false) String param,
                          @RequestParam(value = "offset") int offset,
                          @RequestParam(value = "limit") int limit) throws JsonProcessingException {

        Division division = param != null ? new ObjectMapper().readValue(param, Division.class) : null;

        long rows = service.count(division);

        return new RestResult(rows > 0 ? service.find(division, offset, limit) : new ArrayList<>(), rows);
    }

    @PostMapping
    public RestResult save(@RequestBody Division param){
        param = service.save(param);

        return new RestResult(param, param != null ? StatusCode.SAVE_SUCCESS : StatusCode.SAVE_FAILED);
    }

    @PutMapping
    public RestResult update(@RequestBody Division division){
        division = service.update(division);

        return new RestResult(division, division != null ? StatusCode.UPDATE_SUCCESS : StatusCode.UPDATE_FAILED);
    }

//    @DeleteMapping(value = "{id}")
//    public RestResult delete(@PathVariable Long id){
//        boolean deleted = false;
//        Division division = service.searchById(id);
//
//        if (division != null){
//            service.statusDelete(id);
//            deleted = service.delete(id);
//        }
//
//        return new RestResult(deleted ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
//    }
}
