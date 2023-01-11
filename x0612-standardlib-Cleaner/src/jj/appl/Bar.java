package jj.appl;

import jj.util.DefaultCleaner;

public class Bar {

	final Resource resource0 = new Resource("Hello");
	final Resource resource1 = new Resource("World");
	
	static class ResourceHolder implements Runnable {
		final Resource r;
        ResourceHolder(Resource r) {
        	this.r = r;
        }
        public void run() {
        	this.r.cleanup();
        }
    }

	final ResourceHolder resourceHolder0 = new ResourceHolder(resource0);
	final ResourceHolder resourceHolder1 = new ResourceHolder(resource1);
	
	public Bar() {
		DefaultCleaner.instance.register(this, resourceHolder0);
		DefaultCleaner.instance.register(this, resourceHolder1);
	}

	public void doSomething() {
		System.out.println("doSomething with " + this.resource0 + " and " + this.resource1);
	}
}
