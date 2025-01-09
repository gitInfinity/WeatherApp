import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.tasks.InputFiles
import org.gradle.work.Incremental
import org.gradle.work.InputChanges
import org.gradle.api.tasks.TaskAction
import org.gradle.work.FileChange
import org.gradle.work.ChangeType

abstract class MyIncrementalTask : DefaultTask() {

    @get:InputFiles
    abstract val inputFiles: ConfigurableFileCollection

    @Incremental
    @TaskAction
    fun doTaskAction(inputs: InputChanges) {
        if (inputs.isIncremental) {
            inputs.getFileChanges(inputFiles).forEach {
                when (it.changeType) {
                    ChangeType.ADDED -> {
                        println("File added: ${it.file}")
                    }
                    ChangeType.MODIFIED -> {
                        println("File changed: ${it.file}")
                    }
                    ChangeType.REMOVED -> {
                        println("File removed: ${it.file}")
                    }
                    else -> {
                        println("Unknown change type: ${it.changeType} for file: ${it.file}")
                    }
                }
            }
        } else {
            println("Full task execution")
            inputFiles.files.forEach {
                println("File: ${it.absolutePath}")
            }
        }
    }
}