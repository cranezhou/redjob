package com.s24.redjob.worker.events;

import com.s24.redjob.worker.Execution;
import com.s24.redjob.worker.Worker;
import org.springframework.context.ApplicationEvent;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * Worker successfully executed a job.
 */
public class JobSuccess extends ApplicationEvent implements JobFinished {
   /**
    * Worker.
    */
   private final Worker worker;

   /**
    * Queue.
    */
   private final String queue;

   /**
    * Job execution.
    */
   private final Execution execution;

   /**
    * Job runner.
    */
   private final Object runner;

   /**
    * Constructor.
    *
    * @param worker
    *           Worker.
    * @param queue
    *           Queue.
    * @param execution
    *           Job execution.
    * @param runner
    *           Job runner.
    */
   public JobSuccess(Worker worker, String queue, Execution execution, Object runner) {
      super(worker);
      Assert.notNull(worker, "Precondition violated: worker != null.");
      Assert.hasLength(queue, "Precondition violated: queue has length.");
      Assert.notNull(execution, "Precondition violated: execution != null.");
      Assert.notNull(runner, "Precondition violated: runner != null.");
      this.worker = worker;
      this.queue = queue;
      this.execution = execution;
      this.runner = runner;
   }

   @Override
   @SuppressWarnings("unchecked")
   public <W extends Worker> W getWorker() {
      return (W) worker;
   }

   @Override
   public String getQueue() {
      return queue;
   }

   @Override
   public Execution getExecution() {
      return execution;
   }

   @Override
   @SuppressWarnings("unchecked")
   public <R> R getRunner() {
      return (R) runner;
   }

   @Override
   public boolean equals(Object o) {
      return o instanceof JobSuccess &&
            Objects.equals(worker, ((JobSuccess) o).worker) &&
            Objects.equals(queue, ((JobSuccess) o).queue) &&
            Objects.equals(execution, ((JobSuccess) o).execution) &&
            Objects.equals(runner, ((JobSuccess) o).runner);
   }

   @Override
   public int hashCode() {
      return Objects.hash(worker, queue, execution);
   }
}
