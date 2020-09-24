package com.sts.demo

import com.sts.demo.repo.RepoTopics
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import javax.persistence.Entity
import javax.persistence.Id


@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
@Entity
class Topic(@Id var id: String?, var name: String?, var decription: String?) {
    constructor() : this("","","") {

    }
}

/*
It is the same above class. It is full view of Topic class . This is secondary constructor otherwise primary constructoor in above
class Topic {
    var id: String? = null
    var name: String? = null
    var decription: String? = null

    constructor(id: String?, name: String?, decription: String?) : super() {
        this.id = id
        this.name = name
        this.decription = decription
    }

}
*/
/*
@Service
class TopicService {
    private val topicsMember: ArrayList<Any?> = ArrayList<Any?>(Arrays.asList(
            Topic("1", "Tohir", "He is senior programmer"),
            Topic("2", "Sardor", "He is high-level senior programmer")
    ))

    val all: ArrayList<Any?>
        get() {
           return topicsMember
        }



    fun addTopic(topic: Topic) {
        topicsMember.add(topic)
    }

    fun updateTopic(id: String, topic: Topic?) {
        for (i in topicsMember.indices) {
            val take: Topic = topicsMember[i] as Topic
            if (take.id == id) {
                topicsMember[i] = topic
            }
        }
    }
    fun deleteTopic(id: String?) {
        topicsMember.remove(id)
    }
}
*/


@RestController //it is converting automatically to json format
class TopicContreoller {
    @Autowired
    private val topicservice:RepoTopics?=null
   // private val topicservice: TopicService? = null

    @get:RequestMapping("/topics")
    val allTopics: MutableList<Topic>
        get() = topicservice!!.findAll()

   /* @RequestMapping("/topics/{id}")
    fun getOneTopic(@PathVariable id: String?): Topic {
        return topicservice!!.getTopic(id!!)
    }*/

    @RequestMapping(method = [RequestMethod.POST], value = ["/topics"]) //requesetmapping always be get by default, using mesthod change to post request wuth value findout address
    fun addTopic(@RequestBody topic: Topic):Topic{
        topicservice!!.save(topic)
        return topic
    }


    @RequestMapping(method = [RequestMethod.PUT], value = ["/topics/{id}"]) //requesetmapping always be get by default, using mesthod change to post request wuth value findout address
    fun updateAndSave(@RequestBody topic: Topic?) {
        topicservice!!.save(topic!!)
    }

  //  @RequestMapping(method = [RequestMethod.DELETE], value = ["/topics/{id}"])
    @DeleteMapping("/topics/{id}")
    fun deleteTopic(@PathVariable id: String) {
        /*   if (topicservice != null) {
            topicservice.deleteTopic(id)  //instead of like this cheking we can do simple with !! in below
    }*/
        topicservice!!.deleteById(id)
    }
}