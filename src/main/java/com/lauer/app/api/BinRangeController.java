package com.lauer.app.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lauer.app.model.BinRange;

@RestController
public class BinRangeController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/v2/binrange", consumes = MediaType.APPLICATION_XML_VALUE)
    public List<BinRange> getBinRangeXML(@RequestParam(value = "ccnumber") List<String> ccnumber) {
    	
    	List<BinRange> binRanges = new ArrayList<>();
    	for (String number : ccnumber) {
    		binRanges.add(new BinRange(counter.incrementAndGet(), number));
		}
    	
    	return binRanges;
    }
    
    @RequestMapping(value = "/v2/binrange/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<BinRange> getBinRangeJSON(@RequestParam(value = "ccnumber") List<String> ccnumber) {
    	
    	List<BinRange> binRanges = new ArrayList<>();
    	for (String number : ccnumber) {
    		binRanges.add(new BinRange(counter.incrementAndGet(), number));
		}
    	
    	return binRanges;
    }
    
	@RequestMapping(value = "/v2/binrange", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BinRange getBinRangeByJsonPost(@RequestBody String json) {
		return new BinRange(counter.incrementAndGet(), "XX123456");
	}	
	
	@RequestMapping(value = "/v2/binrange", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
	public BinRange getBinRangeByXmlPost(@RequestBody String xml) {
		return new BinRange(counter.incrementAndGet(), "YY123456");
	}    
}
