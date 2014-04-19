<table>
    <caption>Reading Items</caption>
    <th>Id</th>
    <th>Title</th>
    <th>Summary</th>
    <th>Owner</th>
<g:each in="${resources}" var="resource">
    <tr>
        <td>${resource.id}</td>
        <td>${resource.title}</td>
        <td>${resource.summary}</td>
        <td>${resource.createdBy}</td>
    </tr>
</g:each>
</table>