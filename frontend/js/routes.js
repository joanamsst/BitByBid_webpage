//routes.js 

export default {
    home: {
        path: '/',
        controller: 'homeController'
    },
    form: {
        path: '/form',
        controller: 'formController'
    },
    about: {
        path: '/about',
        controller: 'aboutController'
    },
    contact: {
        path: '/contact',
        controller: 'contactController'
    },
    submissions: {
        path: '/submissions',
        controller: 'submissionsController'
    },
    currentPath: {
        path: '',
        controller: ''
    }
};