package com.joongang.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joongang.domain.Criteria;
import com.joongang.domain.ReplyPageDTO;
import com.joongang.domain.ReplyVO;
import com.joongang.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies/")
@Log4j
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/new", consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create (@RequestBody ReplyVO reply) {
		log.info("ReplyVO: "+reply);
		int insertCount = service.register(reply);
		log.info("Reply INSERT COUNT: " +insertCount);
		return insertCount ==1? 
				new ResponseEntity<>("success", HttpStatus.OK): 
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "pages/{bno}/{page}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable Long bno, @PathVariable int page) {
		log.info("getList.......");
		Criteria criteria = new Criteria(page, 10);
		log.info(criteria);
		return new ResponseEntity<>(service.getListPage(criteria, bno), HttpStatus.OK);
	}
	
	@GetMapping(value = "{rno}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {
		log.info("get: " +rno);
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	
	@PreAuthorize("principal.username == #reply.replyer")
	@DeleteMapping(value = "{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@RequestBody ReplyVO reply, @PathVariable("rno") Long rno) {
		log.info("remove: "+rno);
		log.info("replyer: "+reply.getReplyer());
		return service.remove(rno)==1
			? new ResponseEntity<>("success", HttpStatus.OK)
			: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				
	}
	
	@PreAuthorize("principal.username == #reply.replyer")
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH}, value = "{rno}",
			consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO reply, @PathVariable Long rno) {
		reply.setRno(rno);
		log.info("rno: "+rno);
		log.info("reply: "+reply);
		return service.modify(reply)==1? new ResponseEntity<>("success", HttpStatus.OK):
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
