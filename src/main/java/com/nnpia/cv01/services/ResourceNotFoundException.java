package com.nnpia.cv01.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found.")
public class ResourceNotFoundException extends Exception {
}