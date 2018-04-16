package com.pionware.starter.spring5.service;

import java.util.List;

import com.pionware.starter.spring5.model.Bucket;

public interface S3Service {
	public List<Bucket> getBuckets();
	public void insertBucket(Bucket bucket);
	public boolean nameExists(String name);
}
