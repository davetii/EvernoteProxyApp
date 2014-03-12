package com.greatwideweb.notes;

import com.evernote.edam.userstore.Constants;

public class Application
{

  protected static final String authToken = "S=s17:U=1d71df:E=144f21737c1:C=13d9a660bc2:P=1cd:A=en-devtoken:V=2:H=50ee25793faa0d192eb39137a4b435e4";
  protected static final String evernoteHost = "www.evernote.com";
  protected static final String userStoreUrl = "https://" + evernoteHost + "/edam/user";
  protected static final String userAgent = "Evernote/EDAMDemo (Java) " + 
                                          Constants.EDAM_VERSION_MAJOR + "." + 
                                          Constants.EDAM_VERSION_MINOR;
}
