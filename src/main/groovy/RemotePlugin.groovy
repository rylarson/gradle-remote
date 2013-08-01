import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created with IntelliJ IDEA.
 * User: Ryan
 * Date: 7/31/13
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
class RemotePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        addSshTask()
        addScpTask()
    }

    protected void addSshTask(){

    }

    protected void addScpTask(){

    }
}
