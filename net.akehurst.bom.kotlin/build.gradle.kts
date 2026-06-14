/**
 * Copyright (C) 2023 Dr. David H. Akehurst (http://dr.david.h.akehurst.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


plugins {
    `java-platform`
    `maven-publish`
}

allprojects {
    val version_project = "1.8.21"
    val group_project = "net.akehurst.bom"

    group = group_project
    version = version_project

    buildDir = File(rootProject.projectDir, ".gradle-build/${project.name}")
}

dependencies {
    constraints {
        api("net.akehurst.language:agl-processor:4.0.0-rc.6")
        api("net.akehurst.language:agl-processor-jvm8:4.0.0-rc.6")
        api("net.akehurst.language:agl-processor-js:4.0.0-rc.6")
    }
}



publishing {
    publications {
        create<MavenPublication>("myPlatform") {
            from(components["javaPlatform"])
        }
    }
}

