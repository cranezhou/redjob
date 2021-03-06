package com.s24.redjob.worker;

/**
 * Wrapper for job runners which do not implement {@link Runnable}.
 */
public abstract class WrappingRunnable implements Runnable {
   /**
    * Job runner.
    */
   private final Object runner;

   /**
    * Constructor.
    * 
    * @param runner
    *           Job runner.
    */
   public WrappingRunnable(Object runner) {
      this.runner = runner;
   }

   /**
    * Job runner.
    */
   public <R> R unwrap() {
      return (R) runner;
   }
}
