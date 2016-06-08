package com.s24.redjob.queue.worker.events;

import java.util.Objects;

import org.springframework.context.ApplicationEvent;
import org.springframework.util.Assert;

import com.s24.redjob.queue.worker.Worker;

/**
 * New worker starts.
 */
public class WorkerStart extends ApplicationEvent {
   /**
    * Worker.
    */
   private final Worker worker;

   /**
    * Constructor.
    *
    * @param worker
    *           Worker.
    */
   public WorkerStart(Worker worker) {
      super(worker);
      Assert.notNull(worker, "Precondition violated: worker != null.");
      this.worker = worker;
   }

   /**
    * Worker.
    */
   public Worker getWorker() {
      return worker;
   }

   @Override
   public boolean equals(Object o) {
      return o instanceof WorkerStart &&
            Objects.equals(worker, ((WorkerStart) o).worker);
   }

   @Override
   public int hashCode() {
      return Objects.hash(worker);
   }
}