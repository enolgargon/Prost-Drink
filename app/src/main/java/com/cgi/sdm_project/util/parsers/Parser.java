package com.cgi.sdm_project.util.parsers;

import org.w3c.dom.Document;

public interface Parser<T> {

    T execute(Document doc);

}
