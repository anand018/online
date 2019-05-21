package com.mail.services;

import java.util.ArrayList;
import com.mail.dto.ShowBooksDto;

public interface SearchBarService {

	ArrayList<ShowBooksDto> getBooksFromQuery(String query);
}
