// api url
const api_url = 
      "http://localhost/laravel_api/public/api/user/";
  
// Defining async function
async function getapi(url) {
    
    // Storing response
    const response = await fetch(url);
    
    // Storing data in form of JSON
    var data = await response.json();
    console.log(data);
    // if (response) {
    //     hideloader();
    // }
    show(data);
}
// Calling that async function
getapi(api_url);
  
// Function to hide the loader
// function hideloader() {
//     document.getElementById('loading').style.display = 'none';
// }
// Function to define innerHTML for HTML table
function show(data) {
    let tab = 
        `<tr>
          <th>Name</th>
          <th>Division</th>
          <th>Role</th>
          <th>Phone</th>
         </tr>`;
    
    // Loop to access all rows 
    for (let r of data.data) {
        tab += `<tr> 
    <td>${r.name} </td>
    <td>${r.division}</td>
    <td>${r.role}</td> 
    <td>${r.dob}</td>          
</tr>`;

    }
    // Setting innerHTML as tab variable
    document.getElementById("datatablesSimple").innerHTML = tab;
}