package com.pionware.starter.spring5.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.pionware.starter.spring5.model.Bucket;

@Service
public class S3ServiceImpl implements S3Service {
	private final List<Bucket> buckets = new ArrayList<Bucket>();
	
	public S3ServiceImpl() {
		System.out.println("Creating S3ServiceImpl...");
	}		
	@PostConstruct
	public void init() {
		buckets.add(new Bucket(100L, "Bucket100", "Zone1"));
		buckets.add(new Bucket(101L, "Bucket101", "Zone2"));		
	}
	
	@Override
	public List<Bucket> getBuckets() {
	    return this.buckets;
	}

	@Override
	public void insertBucket(Bucket bucket) {
		bucket.setId(buckets.get(buckets.size()-1).getId() + 1);
		this.buckets.add(bucket);
	}
	
	@Override
	public boolean nameExists(String name) {
		if(this.buckets != null) {
			for(Bucket bucket : this.buckets) {
				if(bucket.getName().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

}
