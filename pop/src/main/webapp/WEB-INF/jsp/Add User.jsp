<html>
    <head>
        <title>Add User</title>
        <link rel="stylesheet" href="/css/bootstrap.css"/>
        <script src="/js/angular.min.js"></script>
    </head>

    <body>

        <div class="container">

            <h2>Add User</h2>
            <form class="form-horizontal" action="/addUser" method="post" ng-app="popcorn" ng-controller="pop" name="addUser">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Name:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" ng-model="name" required>
                    </div>
                    <div class="role">
                        <span style="color: red" ng-show="addUser.name.$dirty && addUser.name.$invalid">
                            <span ng-show="addUser.name.$error.required">Name is required</span>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="roll">Roll No:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="roll" placeholder="Enter Roll" name="roll" ng-model="roll" required>
                    </div>
                    <div class="role">
                        <span style="color: red" ng-show="addUser.roll.$dirty && addUser.roll.$invalid">
                            <span ng-show="addUser.roll.$error.required">Roll is required</span>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="alias">Alias:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="alias" placeholder="Enter Nickname" name="alias" ng-model="alias" required>
                    </div>
                    <div class="role">
                      <span style="color: red" ng-show="addUser.alias.$dirty && addUser.alias.$invalid">
                            <span ng-show="addUser.alias.$error.required">Alias is required</span>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-3">
                        <button type="submit" class="btn btn-default" ng-click="submit($event)" ng-model="add">Add</button>
                    </div>
                </div>
            </form>


        </div>
        </div>
    <script>
        var app= angular.module('popcorn',[]);
        app.controller('pop', function($scope) {

            $scope.submit = function (event) {
                if($scope.addUser.$invalid){
                    alert ("Please fill the required fields!!");
                }else if($scope.name.length >20) {
                    alert("name cannot be greater than 20 character");
                    event.preventDefault();
                }
                else
                {
                    alert("Added successfully!!")
                }
            }

        });
    </script>
    </body>

</html>