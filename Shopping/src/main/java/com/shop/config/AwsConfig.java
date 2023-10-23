package com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration

public class AwsConfig {
	 public AWSCredentials credentials() {
	        AWSCredentials credentials = new BasicAWSCredentials(
	                "",
	                ""
	        );
	        return credentials;
	    }

	    @Bean
	    public AmazonS3 amazonS3() {
	        AmazonS3 s3client = AmazonS3ClientBuilder
	                .standard()
	                .withCredentials(new AWSStaticCredentialsProvider(credentials()))
	                .withRegion(Regions.AP_SOUTH_1)
	                .build();
	        return s3client;
	    }


}
