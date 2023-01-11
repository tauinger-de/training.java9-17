module jj.mod {
	provides java.lang.System.LoggerFinder
		with jj.mod.MyLoggerFinder;	
}