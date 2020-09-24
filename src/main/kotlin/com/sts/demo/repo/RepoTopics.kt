package com.sts.demo.repo

import com.sts.demo.Topic
import org.springframework.data.jpa.repository.JpaRepository


interface RepoTopics: JpaRepository<Topic,String>{

}


