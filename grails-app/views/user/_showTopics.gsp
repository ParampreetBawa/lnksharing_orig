<table><caption>${caption}</caption><tr><th>Topic</th><th>Owner By Me</th></tr>
    <g:each in="${topics}" var="topic">
        <tr>
            <td>${topic.name}</td>
            <td>${topic.createdBy.email.equals(session.user) ? "Yes" : "No"}</td></tr>
    </g:each>
</table>