###Fork/Join

Java 7 introduced the fork/join framework.   It provides tools to help speed up parallel processing by attempting to use all available processor cores. It accomplishes this through a divide and conquer approach.

In practice, this means that the framework first “forks,” recursively breaking the task into smaller independent subtasks until they are simple enough to run asynchronously.

After that, the “join” part begins. The results of all subtasks are recursively joined into a single result. In the case of a task that returns void, the program simply waits until every subtask runs.

To provide effective parallel execution, the fork/join framework uses a pool of threads called the ForkJoinPool. This pool manages worker threads of type ForkJoinWorkerThread.

### BinarySemaphore
A binary semaphore provides a signaling mechanism over the access of a single resource. In other words, a binary semaphore provides a mutual exclusion that allows only one thread to access a critical section at a time.

For that, it keeps only one permit available for access. Hence, a binary semaphore has only two states: one permit available or zero permits available.

If you acquire a permit when there is no more permit to acquire again(availablePermit = 0), it will lead to a deadlock situation.

Additionally, the Semaphore class provides the fairness parameter. When set to true, the fairness parameter ensures the order in which the requesting threads acquire permits (based on their waiting time):

###Reentrant Lock
A reentrant lock is a mutual exclusion mechanism that allows threads to reenter into a lock on a resource (multiple times) without a deadlock situation. 
A thread entering into the lock increases the hold count by one every time. Similarly, the hold count decreases when unlock is requested.
Therefore, a resource is locked until the counter returns to zero.

###Differences Between BinarySemaphore and Reentrant Lock
- A binary semaphore is a type of signaling mechanism, whereas a reentrant lock is a locking mechanism**
- No thread is the owner of a binary semaphore. However, the last thread that successfully locked a resource is the owner of a reentrant lock.
- Binary semaphores are non-reentrant by nature, implying that the same thread can’t re-acquire a critical section, else it will lead to a deadlock situation. 
On the other side, a reentrant lock, by nature, allows reentering a lock by the same thread multiple times.
- A binary semaphore provides a higher-level synchronization mechanism by allowing a custom implementation of a locking mechanism and deadlock recovery. 
Thus, it gives more control to the developers. However, the reentrant lock is a low-level synchronization with a fixed locking mechanism.
- Binary semaphores support operations like wait and signal (acquire and release in the case of Java’s Semaphore class) to allow modification of the 
available permits by any process. On the other hand, only the same thread that locked/unlocked a resource can modify a reentrant lock.
- Binary semaphores provide a non-ownership release mechanism. Therefore, any thread can release the permit for a deadlock recovery of a binary semaphore. 
On the contrary, deadlock recovery is difficult to achieve in the case of a reentrant lock. For instance, if the owner thread of a reentrant lock goes into sleep or infinite wait, it won’t be possible to release the resource, and a deadlock situation will result.

###Callable and Runnable Interfaces
The call() method of the Callable interface is a task that returns a result and may throw an exception. Implementers of the callable
interface defines a single method with no arguments called 'call'.
The method interface is similar to Runnable, in that both are designed for classes whose instances are potentially executed by another thread.
A Runnable however does not return a result, and cannot throw a checked exception.