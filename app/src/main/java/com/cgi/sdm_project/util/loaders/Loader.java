package com.cgi.sdm_project.util.loaders;

import java.util.List;

public interface Loader<T> {
    List<T> load();
}
