package com.tryit.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tryit.demo.model.Details;
import com.tryit.demo.model.TableMapping;
import com.tryit.demo.repository.DetailsRepository;

@Service
public class DetailsService {

	@Autowired
	private DetailsRepository detailsrepo;
	
	@Autowired
	private TableService tableService;
	
	public Details save(Details info,int tid) {
		tableService.get(tid).getDetails().add(info);
		info.setDmap(tableService.get(tid));
		return detailsrepo.save(info);
	
	}
	public Details save(Details info) {
		return detailsrepo.save(info);
	}
    public List<Details> getTid(int id){
    	return detailsrepo.findByDmap(tableService.get(id));
    }
	public Details get(int did) {
		return detailsrepo.findById(did).get();
	}
	public void deleteByDid(int id) {
		detailsrepo.deleteById(id);
	}
	public void deleteByRefereence(TableMapping dmap) {
		detailsrepo.deleteByDmap(dmap);
	}
}
