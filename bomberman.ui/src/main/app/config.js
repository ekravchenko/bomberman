export default function config($urlRouterProvider) {
    "ngInject";
    $urlRouterProvider.otherwise('/main');
}