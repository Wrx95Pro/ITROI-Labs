package ua.nure.parser;

import ua.nure.album.entity.ObjectFactory;

public interface Const {

	String TAG_TEXT = "text";
	String TAG_IMAGE = "image";
	String TAG_DATE = "date";
	String TAG_IMAGE_URL = "image_url";
	String TAG_CREATED_BY = "created_by";
	String TAG_USERNAME = "username";
	String TAG_ACCESS_LEVEL = "access_level";
	String ATTRIBUTE_ID = "Id";
	String ALBUMS_NAMESPACE_URI = "http://album.nure.ua/entity";
	String TAG_album = "album";


	String XML_FILE = "xml/Albums.xml";
	String INVALID_XML_FILE = "xml/invalid_albums.xml";
	String XSD_FILE = "xml/Albums.xsd";
	Class<?> OBJECT_FACTORY = ObjectFactory.class;

	String SCHEMA_LOCATION__ATTR_NAME = "schemaLocation";
	String SCHEMA_LOCATION__ATTR_FQN = "xsi:schemaLocation";
	String XSI_SPACE__PREFIX = "xsi";
	String SCHEMA_LOCATION__URI = "http://album.nure.ua/entity Albums.xsd";

	// validation features
	public static final String FEATURE__TURN_VALIDATION_ON =
			"http://xml.org/sax/features/validation";
	public static final String FEATURE__TURN_SCHEMA_VALIDATION_ON =
			"http://apache.org/xml/features/validation/schema";

	String TAG_HEADER = "header";
	String TAG_ALBUMS = "albums";
}
