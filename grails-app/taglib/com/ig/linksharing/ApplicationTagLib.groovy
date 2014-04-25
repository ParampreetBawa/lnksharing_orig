package com.ig.linksharing

class ApplicationTagLib {
//    static defaultEncodeAs = 'html'
    //static encodeAsForTags = [tagName: 'raw']
    static namespace = "ls"
    def unreadItems = { attr ->
        List<Resource> resources = attr.resources
        int count = Integer.parseInt(attr.get('countt'))
        if (count > resources.size()) count = resources.size()
        out << render(template: '/user/showReadingItems', model: [resources: resources.subList(0, count)])
    }
    def subscribedTopics = { attr ->
        out << render(template: '/user/showTopics', model: [topics: attr.topics, caption: 'Subscribed Topics'])
    }
    def ownedTopics = { attr ->
        User user = User.findByEmail(session.user)
        List<Topic> list = attr.topic
        list = list.each { it.createdBy.email == user.email }
        out << render(template: '/user/showTopics', model: [topics: list, caption: 'Owned Topics'])
    }
    def formattedDate = { attr ->
        String format = attr.format
        Date date = new Date()

        String formatedDate = ''
        try {
            formatedDate = date.format(format)
        } catch (Exception e) {
            formatedDate = date.format("dd-MM-yyyy")
        }
        out << formatedDate
    }
    def allTopics = { attr ->
        User user = User.findByEmail(session.user)
        List<Subscription> subscriptionsOfUser = attr.subscriptionsOfUser
        List<Topic> allTopics = attr.allTopics
        StringBuffer buffer = new StringBuffer()
        buffer.append("<table><caption>Public Topics</caption>")//<th>ID</th><th>Is Private</th>
        buffer.append("<tr><th>Name</th><th>Subscribed</th></tr>")
        allTopics.findAll {!it.isPrivate}.each { Topic topic ->
            /*buffer.append("<tr><td>${topic.id}</td>")*/
            buffer.append("<td><a href=${g:createLink(controller: 'topic',action: 'show',id: topic.id)}>${topic.name}</a></td>")
            if (subscriptionsOfUser.find { it.topic.id.equals(topic.id)}) {
                buffer.append("<td>Yes")
//                buffer.append("<a href='#' onclick='toggle(${topic.id},1)'>(unsubscribe)</a></td>")
                buffer.append("<a href=${createLink(controller: 'user',action: 'unSubscribeTopic',id: topic.id)}>(unsubscribe)</a></td>")
            }
            else {
                buffer.append("<td>No")
                buffer.append("<a href=${createLink(controller: 'user',action: 'subscribeTopic',id: topic.id)}>(subscribe)</a></td>")
            }
            buffer.append("</tr>")
        }
        buffer.append("</table>")
        out << buffer.toString()
    }
    def privateTopics = { attr->
        User user = User.findByEmail(session.user)
        List<Subscription> subscriptionsOfUser = attr.subscriptionsOfUser
        List<Topic> allTopics = attr.allTopics
        StringBuffer buffer = new StringBuffer()
        buffer.append("<table><caption>Private Topics</caption>")//<th>ID</th><th>Is Private</th>
        buffer.append("<tr><th>Name</th><th>Subscribed</th><th>Change Visibility</th></tr>")
        allTopics.findAll {it.isPrivate && it.createdBy.equals(user)}.each { Topic topic ->
            buffer.append("<td><a href=${g:createLink(controller: 'topic',action: 'show',id: topic.id)}>${topic.name}</a></td>")
            if (subscriptionsOfUser.find { it.topic.id.equals(topic.id)}) {
                buffer.append("<td>Yes")
//                buffer.append("<a href='#' onclick='toggle(${topic.id},1)'>(unsubscribe)</a></td>")
                buffer.append("<a href=${createLink(controller: 'user',action: 'unSubscribeTopic',id: topic.id)}>(unsubscribe)</a></td>")
            }
            else {
                buffer.append("<td>No")
                buffer.append("<a href=${createLink(controller: 'user',action: 'subscribeTopic',id: topic.id)}>(subscribe)</a></td>")
            }
            if (topic.isPrivate){
                buffer.append("<td>Yes")
                buffer.append("<a href=${createLink(controller: 'topic',action: 'makePublic',id: topic.id)}>(make public)</a></td>")
            }
            else
                buffer.append("</tr>")
        }
        out << buffer.toString()
    }
}
