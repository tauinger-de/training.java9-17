module jj.appl {
	requires jj.util;
	requires jj.reflection;
	//opens jj.domain; 
	opens jj.domain to jj.reflection.Mapper; 
}