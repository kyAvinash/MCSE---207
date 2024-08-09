import random
import time

# Simulate a basic multiprocessor system

class Processor:
    def __init__(self, id):
        self.id = id
        self.load = 0

    def add_load(self, load):
        self.load += load

    def __str__(self):
        return f"Processor {self.id} with load {self.load}"

class MultiprocessorSystem:
    def __init__(self, num_processors):
        self.processors = [Processor(i) for i in range(num_processors)]

    def distribute_task(self, task_load):
        # Distribute tasks to the processor with the least load
        min_processor = min(self.processors, key=lambda p: p.load)
        min_processor.add_load(task_load)
        print(f"Task with load {task_load} assigned to Processor {min_processor.id}")

    def display_status(self):
        for processor in self.processors:
            print(processor)

# Example usage
if __name__ == "__main__":
    # Create a multiprocessor system with 4 processors
    system = MultiprocessorSystem(num_processors=4)

    # Simulate distributing tasks
    for i in range(10):
        task_load = random.randint(1, 10)
        system.distribute_task(task_load)
        time.sleep(1)  # Simulate time delay between tasks

    # Display final status of all processors
    print("\nFinal Status of Processors:")
    system.display_status()
